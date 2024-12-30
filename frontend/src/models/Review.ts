import {ReviewCategoryScore} from "./ReviewCategoryScore";

export interface Review {
    id: number;
    createdAt: Date;
    updatedAt: Date;
    userId: number;
    gameId: number;
    categoryScores: ReviewCategoryScore[];
}