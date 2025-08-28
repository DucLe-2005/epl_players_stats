import { motion } from "framer-motion";
import { Search, Users, Trophy, BarChart3, ArrowRight } from "lucide-react";
import { useNavigate } from "react-router-dom";
import Button from "@/components/ui/Button";
import Input from "@/components/ui/Input";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/Card";
import logo from "../assets/premier_league_logo.png"; // or public: src="/epl-logo.png"

export default function HomePage() {
  const navigate = useNavigate();

  return (
    <div className="text-[var(--text)]">
      {/* Thin accent bar for brand identity */}
      <div className="h-1" style={{ background: "linear-gradient(90deg, var(--accent), var(--primary))" }} />

      <section className="grid grid-cols-1 lg:grid-cols-2 gap-8 items-center py-12">
        {/* Left: copy + actions */}
        <motion.div initial={{opacity:0, y:10}} animate={{opacity:1, y:0}} transition={{duration:0.5}} className="space-y-8">
          <span className="inline-flex items-center rounded-full px-3 py-1 text-sm font-medium" style={{ background: "color-mix(in hsl, var(--accent) 15%, transparent)", color: "var(--accent)" }}>
            EPLStats
          </span>

          <h1 className="text-4xl md:text-5xl font-extrabold leading-tight">
            Let’s browse your <span style={{ color: "var(--accent)" }}>players</span>.
            <br className="hidden md:block" />
            Explore <span style={{ color: "var(--primary)" }}>stats</span> and <span style={{ color: "var(--accent)" }}>insights</span>.
          </h1>

          <p className="max-w-prose text-[var(--muted)]">
            Search by player, team, or position. Filter by season, age, and nationality. Turn numbers into stories.
          </p>

          {/* Search (not wired yet) */}
          <div className="flex w-full max-w-xl items-center gap-2">
            <div className="relative w-full">
              <Search className="absolute left-3 top-1/2 -translate-y-1/2 h-4 w-4 text-[var(--muted)]" />
              <Input placeholder="Search players, teams, positions…" className="pl-9" />
            </div>
            <Button>Search</Button>
          </div>

          {/* Quick Actions */}
          <div className="flex flex-wrap gap-3">
            <Button variant="secondary" onClick={() => navigate("/players")} className="gap-2">
              <Users className="h-4 w-4" /> Explore Players
            </Button>
            <Button variant="secondary" onClick={() => alert('Teams page coming soon')} className="gap-2">
              <Trophy className="h-4 w-4" /> Explore Teams
            </Button>
            <Button variant="secondary" onClick={() => alert('Compare coming soon')} className="gap-2">
              <BarChart3 className="h-4 w-4" /> Compare
            </Button>
          </div>

          {/* Highlights */}
          <div className="grid grid-cols-1 sm:grid-cols-3 gap-3 text-center">
            <Stat value="20" label="Clubs" />
            <Stat value="500+" label="Players" />
            <Stat value="38" label="Matchweeks" />
          </div>
        </motion.div>

        {/* Right: logo card */}
        <motion.div initial={{opacity:0, scale:0.96}} animate={{opacity:1, scale:1}} transition={{duration:0.5, delay:0.05}} className="flex justify-center">
          <div className="rounded-3xl bg-[var(--surface)] border border-[var(--border)] p-6 shadow-2xl">
            <img
              src={logo}
              alt="English Premier League logo"
              className="h-72 w-72 sm:h-[22rem] sm:w-[22rem] object-contain"
            />
          </div>
        </motion.div>
      </section>

      {/* Three columns */}
      <section className="grid grid-cols-1 lg:grid-cols-3 gap-6 pb-10">
        <Card>
          <CardHeader><CardTitle>Popular Teams</CardTitle></CardHeader>
          <CardContent>
            <ul className="grid grid-cols-2 gap-3 text-sm">
              {["Arsenal","Chelsea","Liverpool","Manchester City","Manchester United","Tottenham"].map(t=>(
                <li key={t} className="rounded-lg bg-[var(--surface)] border border-[var(--border)] px-3 py-2">{t}</li>
              ))}
            </ul>
          </CardContent>
        </Card>

        <Card>
          <CardHeader><CardTitle>Top Performers (Sample)</CardTitle></CardHeader>
          <CardContent>
            <div className="space-y-3">
              {[
                { name: "Erling Haaland", stat: "27 G", team: "Manchester City" },
                { name: "Bukayo Saka", stat: "15 G / 10 A", team: "Arsenal" },
                { name: "Mohamed Salah", stat: "18 G / 9 A", team: "Liverpool" },
              ].map(p=>(
                <div key={p.name} className="flex items-center justify-between rounded-xl bg-[var(--surface)] border border-[var(--border)] px-3 py-2">
                  <div>
                    <p className="font-medium">{p.name}</p>
                    <p className="text-xs text-[var(--muted)]">{p.team}</p>
                  </div>
                  <span style={{ color: "var(--accent)" }} className="text-sm font-semibold">{p.stat}</span>
                </div>
              ))}
            </div>
          </CardContent>
        </Card>

        <Card>
          <CardHeader><CardTitle>Get Started</CardTitle></CardHeader>
          <CardContent>
            <CTA title="Browse all players" desc="Filter by position, age, nationality, or club." onClick={()=>navigate("/players")} />
            <CTA title="Teams overview"     desc="Drill into rosters and team stats."              onClick={()=>alert('Soon')} />
            <CTA title="Head-to-head compare" desc="Compare players across seasons or metrics."     onClick={()=>alert('Soon')} />
          </CardContent>
        </Card>
      </section>
    </div>
  );
}

function Stat({ value, label }) {
  return (
    <div className="rounded-xl bg-[var(--surface)] border border-[var(--border)] px-4 py-3">
      <div className="text-xl font-bold">{value}</div>
      <div className="text-xs uppercase tracking-wide text-[var(--muted)]">{label}</div>
    </div>
  );
}

function CTA({ title, desc, onClick }) {
  return (
    <button onClick={onClick} className="group w-full text-left rounded-xl bg-[var(--surface)] border border-[var(--border)] p-4 hover:bg-[var(--surface)]/80 transition">
      <div className="flex items-start justify-between">
        <div>
          <h3 className="font-semibold">{title}</h3>
          <p className="text-sm text-[var(--muted)]">{desc}</p>
        </div>
        <ArrowRight className="h-5 w-5 text-[var(--muted)] group-hover:translate-x-1 transition" />
      </div>
    </button>
  );
}
