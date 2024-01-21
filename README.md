hoi4MapTool is a self coded Mod tool in Java with the help of ChatGpt.

All can use and modifie the source code

In finder.java write the Hoi4 game folder from that you extract the vanilla game States files. eingabeOrdnerPfad = "Path";
Also write the path where you like to locate the solution String ausgabeOrdnerPfad = "Path";
in replace.java write the Hoi4 game folder from that you extract the vanilla game States files. ordnerPfad = "C:\\Users\\TheLastDust\\Documents\\Paradox Interactive\\Hearts of Iron IV\\mod\\SpeedMap\\history\\states";

After you compiel the programm write in console a state name, for example CHI if you want what japain have all teretories and core write in consol the replacement tag JAP. if you want unplaiable teretories you write in consol the replacment tag # .

In my experiance in Hoi4 is a modding bug, if you want the (Tag)SAU to make unplaebel teretorie in on of the SAU States file you must write add_core_of = SAU, and not what the  program replace add_core_of = # if whey is # the game crash, but in all other files you can use # .
