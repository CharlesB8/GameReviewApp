import {Tag} from "./Tag";
import {Review} from "./Review";

export interface Game {
    id: number;
    title: string;
    description: string;
    thumbnailSrc: string;
    // tags: Tag[];
    // reviews: Review[];
}