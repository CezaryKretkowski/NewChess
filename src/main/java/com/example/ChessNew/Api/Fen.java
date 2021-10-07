package com.example.ChessNew.Api;

public class Fen {
	protected String fenString;
	public Fen(String fenString) {
		this.fenString=fenString;
	}
	public Fen(){
	    	this.fenString="";
	}
    public char[][] fenToTab(){
        int l=0;
        char[][] tab= new char [8][8];
        for(int i=0;i<8;++i){
            for(int j=0;j<8;++j){
                if(fenString.charAt(l)!='/'){
                    if(fenString.charAt(l)<='8'&&fenString.charAt(l)>='1')
                    {
                        int a=fenString.charAt(l)-'0';
                        a=a+j;
                        int w=j;
                        while(w<a){
                            tab[i][w]='0';
                            w++;
                        }
                        a=a-j;
                        j=j+a-1;
                    }
                    else
                        tab[i][j]=fenString.charAt(l);
                }
                l++;
            }
            l++;
        }
        
        return tab;
    }
    public String tabToFen(char [][]tab){
        String fen="";
        for(int i =0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                char current = tab[i][j];
                if (current <= 'z' && current >= 'A')
                    fen =fen+current;
                else {
                    int w=0;
                    NullCountLoop:
                    while (tab[i][j]<'A'){
                        w++;

                        j++;
                        if(j>7)
                            break NullCountLoop;

                    }
                    j=j-1;
                    char a=(char)w;
                    a= (char) (a+'0');
                    fen=fen+a;
                }

            }
            fen=fen+"/";
        }
        return fen;
    }

    public char[][] fenToTab(String fen){
        int l=0;
        char[][] tab= new char [8][8];
        for(int i=0;i<8;++i){
            for(int j=0;j<8;++j){
                if(fen.charAt(l)!='/'){
                    if(fen.charAt(l)<='8'&&fen.charAt(l)>='1')
                    {
                        int a=fen.charAt(l)-'0';
                        a=a+j;
                        int w=j;
                        while(w<a){
                            tab[i][w]='0';
                            w++;
                        }
                        a=a-j;
                        j=j+a-1;
                    }
                    else
                        tab[i][j]=fen.charAt(l);
                }
                l++;
            }
            l++;
        }

        return tab;
    }

    public String getFenString() {
        return fenString;
    }

    public void setFenString(String fenString) {
        this.fenString = fenString;
    }
}
