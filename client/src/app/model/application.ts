import { Timestamp } from "rxjs";
import { Environment } from "./environment";
import { User } from "./user"


export class Application{
    id: number;
    name: string;
    validFrom?: Date;
    description?: string;
    contact: string;
    admins: User[] ; 
    environments: Environment[];

}