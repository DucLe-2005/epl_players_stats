import { forwardRef } from "react";
export const Input = forwardRef(function Input({ className="", ...props }, ref) {
  return (
    <input
      ref={ref}
      className={`h-10 w-full rounded-xl bg-[var(--surface)] border border-[var(--border)] px-3 text-sm text-[var(--text)] placeholder:text-[var(--muted)] focus:outline-none focus:ring-2 focus:ring-[var(--ring)] ${className}`}
      {...props}
    />
  );
});
export default Input;
