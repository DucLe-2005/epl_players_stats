export function Card({ className="", ...props }) {
  return <div className={`rounded-2xl bg-[var(--surface)] border border-[var(--border)] shadow-xl ${className}`} {...props} />;
}
export const CardHeader = ({ className="", ...props }) => <div className={`px-4 pt-4 ${className}`} {...props} />;
export const CardTitle  = ({ className="", ...props }) => <h3 className={`text-lg font-semibold ${className}`} {...props} />;
export const CardContent= ({ className="", ...props }) => <div className={`px-4 pb-4 text-[var(--muted)] ${className}`} {...props} />;
