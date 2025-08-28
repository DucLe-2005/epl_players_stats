import { useMemo, useState } from "react";
import { useNavigate } from "react-router-dom";
import { Search } from "lucide-react";
import Input from "@/components/ui/Input";
import Button from "@/components/ui/Button";
import { teamObjects } from "@/assets/information";

const TEAMS = teamObjects;

export default function TeamsPage() {
  const [query, setQuery] = useState("");
  const navigate = useNavigate();

  const filtered = useMemo(() => {
    const q = query.trim().toLowerCase();
    if (!q) return TEAMS;
    return TEAMS.filter(t => t.name.toLowerCase().includes(q));
  }, [query]);

  return (
    <div className="space-y-6 text-[var(--text)]">
      {/* Header */}
      <div className="flex flex-col md:flex-row md:items-center md:justify-between gap-3">
        <div>
          <h1 className="text-3xl font-bold">Teams</h1>
          <p className="text-sm text-[var(--muted)]">Browse all Premier League clubs.</p>
        </div>

        {/* Search */}
        <div className="flex items-center gap-2 w-full md:w-96">
          <div className="relative w-full">
            <Search className="absolute left-3 top-1/2 -translate-y-1/2 h-4 w-4 text-[var(--muted)]" />
            <Input
              value={query}
              onChange={(e) => setQuery(e.target.value)}
              placeholder="Search clubs…"
              className="pl-9"
            />
          </div>
          <Button variant="secondary" onClick={() => setQuery("")}>Clear</Button>
        </div>
      </div>

      {/* Grid */}
      <div className="grid grid-cols-2 sm:grid-cols-3 md:grid-cols-4 xl:grid-cols-5 gap-4">
        {filtered.map((team) => (
          <TeamCard
            key={team.name}
            team={team}
            onClick={() => navigate(`/teams/${slugify(team.name)}`)}
          />
        ))}
      </div>
    </div>
  );
}

/* -------- TeamCard -------- */
function TeamCard({ team, onClick }) {
  return (
    <button
      onClick={onClick}
      className="group rounded-2xl bg-[var(--surface)] border border-[var(--border)] p-4 text-left shadow hover:shadow-lg hover:border-[var(--accent)]/50 transition"
    >
      <div className="aspect-square w-full rounded-xl bg-[var(--bg)] border border-[var(--border)] flex items-center justify-center overflow-hidden">
        {team.logo ? (
          <img
            src={team.logo}
            alt={team.name}
            className="max-h-24 max-w-[80%] object-contain group-hover:scale-105 transition"
          />
        ) : (
          <div className="text-[var(--muted)] text-sm">No Logo</div>
        )}
      </div>
      <div className="mt-3">
        <h3 className="font-semibold leading-tight">{team.name}</h3>
        <p className="text-xs text-[var(--muted)]">View club details</p>
      </div>
    </button>
  );
}