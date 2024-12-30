import React, { useEffect, useState } from 'react';
import api from '../../api';

interface Game {
    id: number;
    title: string;
    description: string;
}

function GameList() {
    const [games, setGames] = useState<Game[]>([]);

    useEffect(() => {
        api.get('/games')
            .then(response => {
                setGames(response.data);
            })
            .catch(error => {
                console.error('Error fetching games:', error);
            });
    }, []); // [] loads the component after the page loads

    return (
        <div>
        <h1>Game List</h1>
            {games.map(game => (
                <div key={game.id}>
                    <h2>{game.title} - {game.description}</h2>
                    <ul>
                        {/*<li>{game.reviews}</li>*/}
                    </ul>
                </div>
            ))}
        </div>
    );
}

export default GameList;
