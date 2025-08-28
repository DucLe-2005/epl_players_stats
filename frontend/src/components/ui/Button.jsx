export function Button({ variant = "default", size = "md", className = "", ...props }) {
  const base = "inline-flex items-center justify-center rounded-xl text-sm font-medium transition focus:outline-none focus:ring-2 focus:ring-[var(--ring)]";
  const variants = {
    default: "bg-[var(--accent)] text-black hover:brightness-95",
    secondary: "bg-[var(--surface)] text-[var(--text)] border border-[var(--border)] hover:bg-[var(--surface)]/80",
    ghost: "bg-transparent text-[var(--text)] hover:bg-[var(--surface)]/60",
  };
  const sizes = { sm: "h-9 px-3", md: "h-10 px-4", lg: "h-11 px-5" };

  return (
    <button className={`${base} ${variants[variant]} ${sizes[size]} ${className}`} {...props} />
  );
}
export default Button;
