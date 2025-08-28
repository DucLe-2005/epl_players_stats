import { Link, NavLink } from "react-router-dom";

export default function Layout({ children }) {
  const linkBase = "px-3 py-2 rounded-xl text-sm";
  const active = "bg-[var(--surface)] border border-[var(--border)]";
  return (
    <div className="min-h-screen bg-[var(--bg)] text-[var(--text)]">
      <header className="sticky top-0 z-50 border-b border-[var(--border)] bg-[color-mix(in_hsl,var(--bg),transparent 15%)] backdrop-blur">
        <div className="mx-auto max-w-7xl px-6 h-14 flex items-center justify-between">
          <Link to="/" className="font-bold" style={{ color: "var(--accent)" }}>
            EPLStats
          </Link>
          <nav className="flex gap-1">
            <NavLink to="/players" className={({isActive}) => `${linkBase} ${isActive ? active : "hover:bg-[var(--surface)]/60"}`}>Players</NavLink>
            <NavLink to="/teams"   className={({isActive}) => `${linkBase} ${isActive ? active : "hover:bg-[var(--surface)]/60"}`}>Teams</NavLink>
            <NavLink to="/compare" className={({isActive}) => `${linkBase} ${isActive ? active : "hover:bg-[var(--surface)]/60"}`}>Compare</NavLink>
          </nav>
        </div>
      </header>

      <main className="mx-auto max-w-7xl px-6 py-8">{children}</main>

      <footer className="border-t border-[var(--border)] px-6 py-6 text-sm text-[var(--muted)]">
        © {new Date().getFullYear()} EPLStats • Not affiliated with the Premier League
      </footer>
    </div>
  );
}
