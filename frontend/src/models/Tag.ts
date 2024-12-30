import {Game} from "./Game";

export interface Tag {
    name: string;
    description: string;
    games: Game[];
    tags: Tag[];
}