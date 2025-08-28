import { Link, NavLink } from "react-router-dom";

export default function Navbar() {
  const linkBase = "px-3 py-2 rounded-lg";
  const active = "bg-white/10";
  return (
    <header className="sticky top-0 z-50 backdrop-blur bg-[#0a0010]/70 border-b border-white/10">
      <div className="mx-auto max-w-7xl px-6 h-14 flex items-center justify-between">
        <Link to="/" className="font-bold text-[#00ff85]">EPLStats</Link>
        <nav className="flex gap-1 text-sm">
          <NavLink to="/players" className={({isActive}) => `${linkBase} ${isActive?active:""}`}>Players</NavLink>
          <NavLink to="/teams" className={({isActive}) => `${linkBase} ${isActive?active:""}`}>Teams</NavLink>
          <NavLink to="/compare" className={({isActive}) => `${linkBase} ${isActive?active:""}`}>Compare</NavLink>
        </nav>
      </div>
    </header>
  );
}
