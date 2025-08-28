// src/components/players/PlayerCard.jsx
import { Users } from "lucide-react";
import { useMemo } from "react";

export default function PlayerCard({ player, onClick }) {
  // Safe helpers
  const n90 = Number(player?.nineties) || 0;
  const goals = Number(player?.goals) || 0;
  const assists = Number(player?.assists) || 0;
  const ga = Number(player?.goals_plus_assists) || goals + assists;
  const npg = Number(player?.goals_non_penalty) || 0;
  const pens = Number(player?.penalties) || 0;

  const per90 = useMemo(() => {
    const sd = (x) => (n90 > 0 ? (x / n90) : 0);
    return {
      g90: sd(goals),
      a90: sd(assists),
      ga90: sd(ga),
    };
  }, [n90, goals, assists, ga]);

  return (
    <div
      onClick={onClick}
      className="rounded-2xl bg-[var(--surface)] border border-[var(--border)] p-4 shadow hover:shadow-lg transition cursor-pointer"
    >
      {/* Header */}
      <div className="flex items-center gap-4">
        {player?.photo ? (
          <img
            src={player.photo}
            alt={player.name}
            className="h-16 w-16 rounded-full object-cover border border-[var(--border)]"
          />
        ) : (
          <div className="h-16 w-16 flex items-center justify-center rounded-full bg-[var(--bg)] border border-[var(--border)] text-[var(--muted)]">
            <Users className="h-8 w-8" />
          </div>
        )}

        <div className="flex-1 min-w-0">
          <h2 className="text-lg font-semibold truncate">{player?.name}</h2>
          <p className="text-sm text-[var(--muted)] truncate">{player?.team}</p>
          <div className="mt-1 flex flex-wrap gap-2 text-xs">
            <Chip color="accent">{player?.position}</Chip>
            {player?.nation && <Chip>{player.nation}</Chip>}
            {player?.age != null && <Chip>{player.age} yrs</Chip>}
          </div>
        </div>
      </div>

      {/* Body */}
      <div className="mt-4 grid grid-cols-3 gap-2 text-center">
        <KPI label="G + A" value={fmtInt(ga)} />
        <KPI label="Starts" value={fmtInt(player?.starts)} />
        <KPI label="Minutes" value={fmtInt(player?.minutes)} />
      </div>

      {/* Per-90 row */}
      <div className="mt-3 grid grid-cols-3 gap-2 text-center text-xs">
        <Per90 label="G/90" value={per90.g90} />
        <Per90 label="A/90" value={per90.a90} />
        <Per90 label="G+A/90" value={per90.ga90} highlight />
      </div>

      {/* Badges */}
      <div className="mt-3 flex flex-wrap gap-2 text-xs">
        {npg ? <Badge>NPG: {fmtInt(npg)}</Badge> : null}
        {pens ? <Badge>PK: {fmtInt(pens)}</Badge> : null}
      </div>
    </div>
  );
}

/* ——— Little UI helpers ——— */

function KPI({ label, value }) {
  return (
    <div className="rounded-xl bg-[var(--bg)] border border-[var(--border)] py-2 px-3">
      <div className="text-base font-semibold">{value}</div>
      <div className="text-[var(--muted)] text-[11px]">{label}</div>
    </div>
  );
}

function Per90({ label, value, highlight }) {
  return (
    <div className={`rounded-lg py-2 px-2 border text-[11px] ${highlight
      ? "border-[var(--accent)]/60 bg-[var(--surface)]"
      : "border-[var(--border)] bg-[var(--surface)]"
    }`}>
      <div className={`font-semibold ${highlight ? "text-[var(--accent)]" : ""}`}>
        {fmtPer90(value)}
      </div>
      <div className="text-[var(--muted)]">{label}</div>
    </div>
  );
}

function Chip({ children, color }) {
  const cls = color === "accent"
    ? "text-[var(--accent)] border-[var(--border)]"
    : "text-[var(--muted)] border-[var(--border)]";
  return (
    <span className={`px-2 py-0.5 rounded-full bg-[var(--bg)] border ${cls}`}>{children}</span>
  );
}

function Badge({ children }) {
  return (
    <span className="px-2 py-0.5 rounded-lg bg-[var(--bg)] border border-[var(--border)] text-[var(--muted)]">
      {children}
    </span>
  );
}

/* ——— Formatting ——— */

function fmtInt(x) {
  const n = Number(x);
  if (!Number.isFinite(n)) return "—";
  return n.toLocaleString();
}

function fmtPer90(x) {
  const n = Number(x);
  if (!Number.isFinite(n)) return "—";
  // one decimal is readable for per-90
  return n.toFixed(1);
}
