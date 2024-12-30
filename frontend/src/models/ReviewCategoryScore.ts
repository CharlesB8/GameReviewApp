import {Game} from "./Game";

export interface ReviewCategoryScore {
   score: number;
   opinion: string | null;
   games: Game;
}