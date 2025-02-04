import React, { useEffect, useState } from 'react';
import api from '../../api';
import {Game} from "../../models/Game";
import Header from "../components/Header";
import '../../index.css'

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
    }, []);

    return (
        <div>
            <Header title="Game List" />
            {games.map(game => (
                <div key={game.id}>
                    <img alt="Game thumbnail" src={game.thumbnailSrc}/>
                    <h2>{game.title} - {game.description}</h2>
                </div>
            ))}
        </div>
    );
}

export default GameList;
