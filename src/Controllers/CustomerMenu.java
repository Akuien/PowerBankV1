package Controllers;

import Entities.UserInput;

public class CustomerMenu {



    public void CustomerMenu(){

        int option = UserInput.inputInt(" ");

        while(option > 0 || option < 8){

            option = UserInput.inputInt("Invalid option");

        }switch(option){

            case 0 : ;
                break;
            case 1 : ;
                break;
                case 2 : ;


        }

    }

}
