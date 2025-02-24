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
            <div className="flex flex-col items-center justify-center gap-y-6 top-5">
                {games.map(game => (
                    <div key={game.id} className="flex items-center justify-center gap-4 gap-y-10">
                        <img alt="Game thumbnail" src={game.thumbnailSrc} className="size-20 object-cover rounded-lg" />
                        <div className="flex flex-col justify-start gap-2 border-2 border-black w-96">
                            <div className="text-left">
                                <h2 className="text-4xl font-bold">{game.title}</h2>
                            </div>
                            <div className="text-left">
                                <div>{game.description}</div>
                            </div>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
}

export default GameList;
