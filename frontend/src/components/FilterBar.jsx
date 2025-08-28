import React from "react";
import { teams, positions } from "@/assets/information";

export default function FilterBar({
  team,
  position,
  nation,
  name,
  setTeam,
  setPosition,
  setNation,
  setName,
  onClear,
}) {
  const nations = ["England", "Brazil", "Portugal", "Norway"]; // Example

  return (
    <div className="flex flex-wrap gap-3 items-center p-4 rounded-2xl bg-[var(--surface)] border border-[var(--border)] shadow">
      {/* Team */}
      <Select value={team} onChange={(e) => setTeam(e.target.value)}>
        <option value="">All Teams</option>
        {teams.map((t) => (
          <option key={t} value={t}>
            {t}
          </option>
        ))}
      </Select>

      {/* Position */}
      <Select value={position} onChange={(e) => setPosition(e.target.value)}>
        <option value="">All Positions</option>
        {positions.map((p) => (
          <option key={p} value={p}>
            {p}
          </option>
        ))}
      </Select>

      {/* Nation */}
      <Select value={nation} onChange={(e) => setNation(e.target.value)}>
        <option value="">All Nations</option>
        {nations.map((n) => (
          <option key={n} value={n}>
            {n}
          </option>
        ))}
      </Select>

      {/* Search */}
      <input
        type="text"
        placeholder="Search name..."
        value={name}
        onChange={(e) => setName(e.target.value)}
        className="h-10 rounded-xl bg-[var(--bg)] border border-[var(--border)] px-3 text-sm text-[var(--text)] placeholder:text-[var(--muted)] focus:outline-none focus:ring-2 focus:ring-[var(--accent)]"
      />

      {/* Clear Button */}
      <button
        onClick={onClear}
        className="h-10 px-4 rounded-xl text-sm font-medium bg-[var(--accent)] text-black hover:brightness-95 transition"
      >
        Clear
      </button>
    </div>
  );
}

/* 🔹 A small wrapper for selects to keep consistent style */
function Select({ children, ...props }) {
  return (
    <select
      {...props}
      className="h-10 rounded-xl bg-[var(--bg)] border border-[var(--border)] px-3 text-sm text-[var(--text)] focus:outline-none focus:ring-2 focus:ring-[var(--accent)]"
    >
      {children}
    </select>
  );
}
