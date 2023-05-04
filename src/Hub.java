import java.util.Scanner;

public class Hub {
    Container[][] containers;
    int columns = 12;
    int rows = 10;

    Hub() {
        this.containers = new Container[10][12];

        for(int i = 0; i < 10; ++i) {
            for(int j = 0; j < 12; ++j) {
                this.containers[i][j] = new Container();
            }
        }
    }
    Hub(Container[][] containers){
        this.containers=containers;
    }

    String stringState() {
        String str = "";

        for(int i = 0; i < 10; ++i) {
            for(int j = 0; j < 12; ++j) {
                if (this.containers[i][j].ID == 0) {
                    str = str + "0 ";
                }
                if (this.containers[i][j].ID != 0) {
                    str = str + "X ";
                }
            }
            str = str + "\n";
        }
        return str;
    }
    int stackContainer(Container cont) {
        int i;
        if (cont.priorityLevel == 1) {
                for(i = 9; i>=0; --i) {
                    if (this.containers[i][0].ID == 0) {
                        this.containers[i][0].ID = cont.ID;
                        this.containers[i][0].weight = cont.weight;
                        this.containers[i][0].country = cont.country;
                        this.containers[i][0].inspected = cont.inspected;
                        this.containers[i][0].priorityLevel = cont.priorityLevel;
                        this.containers[i][0].description = cont.description;
                        this.containers[i][0].companySend = cont.companySend;
                        this.containers[i][0].companyReceive = cont.companyReceive;
                        return 1;
                    }
                }
            if(i == -1){
                return -1;
            }
            }
        if (cont.priorityLevel == 2) {
            for(i = 9; i>=0; --i) {
                    if (this.containers[i][1].ID == 0) {
                        this.containers[i][1].ID = cont.ID;
                        this.containers[i][1].weight = cont.weight;
                        this.containers[i][1].country = cont.country;
                        this.containers[i][1].inspected = cont.inspected;
                        this.containers[i][1].priorityLevel = cont.priorityLevel;
                        this.containers[i][1].description = cont.description;
                        this.containers[i][1].companySend = cont.companySend;
                        this.containers[i][1].companyReceive = cont.companyReceive;
                        return 1;
                }
            }
            if(i==-1){
                return -1;
            }
        }

        if(cont.priorityLevel==3){
            for(int j=2;j<12;j++){
                for(i=9;i>=0;i--){
                    if(this.containers[i][j].ID==0){
                        this.containers[i][j].ID = cont.ID;
                        this.containers[i][j].weight = cont.weight;
                        this.containers[i][j].country = cont.country;
                        this.containers[i][j].inspected = cont.inspected;
                        this.containers[i][j].priorityLevel = cont.priorityLevel;
                        this.containers[i][j].description = cont.description;
                        this.containers[i][j].companySend = cont.companySend;
                        this.containers[i][j].companyReceive = cont.companyReceive;
                        return 1;
                    }
                }
            }
            return -1;
        }
        return -1;
    }

    void removeContainer(int column) {
        int i;
        for(i = 0; i < 10; ++i) {
            if (this.containers[i][column].ID != 0) {
                this.containers[i][column] = new Container();
                i=10;
            }
        }
    }

    String dataRegisteredContainer(int ID) {
        String str = "Not found";
        for(int i = 0; i < 10; ++i) {
            for(int j = 0; j < 12; ++j) {
                if (this.containers[i][j].ID == ID) {
                    str = "ID: " + ID + "\nWeight: " + this.containers[i][j].weight + "\nCountry of origin: " + this.containers[i][j].country + "\nSender company: " + this.containers[i][j].companySend + "\nReceiving company: " + this.containers[i][j].companyReceive + "\nContent description: " + this.containers[i][j].description + "\nPriority level: " + this.containers[i][j].priorityLevel + "\nInspected: " + this.containers[i][j].inspected;
                    return str;
                }
            }
        }
        return str;
    }

    int containersFromACountry(String country) {
        int counter = 0;
        for(int i = 0; i < 10; ++i) {
            for(int j = 0; j < 12; ++j) {
                if (this.containers[i][j].country==country) {
                    ++counter;
                }
            }
        }
        return counter;
    }

    String c1exercise(int weight,Container cont){
        boolean check;
        if(cont.weight<=weight){
            check=true;
            return ("ID: "+cont.ID+", Sender Company: "+cont.companySend+", Weight: "+cont.weight);
        }else{
            check=false;
           return null;
        }
    }

    Container containerWithID(int ID) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if (this.containers[i][j].ID == ID) {
                    return this.containers[i][j];
                }
            }
        }
        return null;
    }
}


