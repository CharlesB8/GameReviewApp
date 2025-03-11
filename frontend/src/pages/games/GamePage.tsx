import { useParams } from "react-router";
import {useEffect, useState} from "react";
import {Game} from "../../models/Game";
import api from "../../api";
import { useNavigate } from "react-router-dom";

const emptyGame: Game = {
    id: 0,
    title: "",
    description: "",
    thumbnailSrc: ""
    // tags: null,
    // reviews: null
}

function GamePage() {
    const [game, setGame] = useState<Game>(emptyGame);
    const params = useParams();
    const navigate = useNavigate();

    useEffect(() => {
        console.log('/games/' + params.gameId)
       api.get('/games/' + params.gameId)
           .then(response => {
               console.log(response);
               setGame(response.data);
           })
           .catch(error => {
               console.error('Error fetching games:', error);
               if (error.response.status === 404) {
                   navigate("/games");
               } else {
                   alert("Something went wrong");
               }
           });
    }, []);

    return (
        <div>
            <div className="grid grid-cols-3 gap-4 p-4">
                <div className="place-items-center">
                    <h2 className="text-4xl font-bold p-4">{game.title}</h2>
                    <img alt={game.title} src={game.thumbnailSrc} className="p-4 rounded-lg"/>
                    <div className="p-2 border-gray-500x h-1/2 w-4/5 border-4 text-left">
                        <div>
                            <div className="text-xl font-bold">What's this about?:</div>
                            <div>{game.description}</div>
                        </div>
                        <div className="font-bold">Tags:</div>
                    </div>
                    <div className="p-4 justify-self-end">
                        <button className="bg-orange-500 hover:bg-orange-700 text-black font-bold py-2 px-4 rounded">
                            Edit Game
                        </button>
                    </div>
                </div>
                <div className="bg-red-600 text-center">Center column</div>
            </div>
        </div>
    )
}

export default GamePage;