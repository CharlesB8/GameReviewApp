import {Tag} from "./Tag";
import {Review} from "./Review";

export interface Game {
    id: number;
    title: string;
    description: string;
    thumbnail_src: string | null;
    tags: Tag[];
    reviews: Review[];
}