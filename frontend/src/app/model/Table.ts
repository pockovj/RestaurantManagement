import {Produkt} from "./Produkt";
import {Konobar} from "./Konobar";
import {Narachka} from "./Narachka";

export interface Table {
  id: number,
  narachki : Narachka[],
  ime: string,
  totalPrice: number
}
