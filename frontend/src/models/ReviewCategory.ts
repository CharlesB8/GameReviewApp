import {ReviewCategoryScore} from "./ReviewCategoryScore";

export interface ReviewCategory {
    id: number;
    name: string;
    categoryScores: ReviewCategoryScore[];
}