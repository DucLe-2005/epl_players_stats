import { useEffect, useState } from 'react';
import FilterBar from '@/components/FilterBar';
import PlayerCard from '@/components/PlayerCard';
import { fetchPlayers } from '@/service/api';

export default function PlayersPage() {
    const [players, setPlayers] = useState([]);
    const [team, setTeam] = useState('');
    const [position, setPosition] = useState('');
    const [nation, setNation] = useState('');
    const [name, setName] = useState('');
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        loadPlayers();
    }, [team, position, nation, name]);

    async function loadPlayers() {
        setLoading(true);
        try {
            const data = await fetchPlayers({ team, position, nation, name});
            setPlayers(data);
        } catch (err) {
            console.error(err);
        }
        setLoading(false);
    }

    function clearFilters() {
        setTeam('');
        setPosition('');
        setNation('');
        setName('');
    }

    return (
        <div className="p-6">
            <h1 className="text-2xl font-bold mb-4">EPL Players Stats</h1>
            <FilterBar 
                team={team} setTeam={setTeam}
                position={position} setPosition={setPosition}
                nation={nation} setNation={setNation}
                name={name} setName={setName}
                onClear={clearFilters}
            />

            {loading && <p className="mt-4">Loading...</p>}
            <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-4 mt-4">
                {players.map(player => (
                    <PlayerCard key={player.id} player={player} />
                ))}
            </div>

            {!loading && players.length === 0 && (
                <p className="mt-4 text-gray-500">No players found.</p>
            )}
        </div>
    )
}