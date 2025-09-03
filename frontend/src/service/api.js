const API_BASE_URL = import.meta.env.VITE_BACKEND_URL
console.log("API_BASE_URL:", API_BASE_URL);

export async function fetchPlayers({ team, position, nation, name }) {
    const params = new URLSearchParams();
    if (team) params.append('team', team);
    if (position) params.append('position', position);
    if (nation) params.append('nation', nation);
    if (name) params.append('name', name);

    const response = await fetch(`${API_BASE_URL}?${params.toString()}`);
    if (!response.ok) {
        throw new Error('Failed to fetch players');
    }
    console.log(response)
    return response.json();
}