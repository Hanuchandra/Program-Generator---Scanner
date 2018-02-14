#include<iostream>
#include<fstream>
#include<stdlib.h>
#include<string.h>
#include<ctype.h>
using namespace std;
int isKeyword(char buffer[]){
    char keywords[5][10] = {"if","else","then","begin","end"};
    int i, count=0;
    for(i = 0; i < 5; ++i){
        if(strcmp(keywords[i], buffer) == 0){
        	cout<<buffer;
        	cout<<" Is a KEYWORD \n";
        	count++;
        }
    }
    return count;
}
int isid(char buffer[]){
	char keywords[5][10] = {"if","else","then","begin","end"};
	int i, keycount=0,count=0;
	for(i = 0; i < 5; ++i){
        if(strcmp(keywords[i], buffer) == 0)
        	keycount++;
    }
    if(keycount==0) {
	int ascii=int(buffer[0]);
    	if(ascii>=65 && ascii<=122)
    	{
    		cout<<buffer<<" Is an IDENTIFIER \n";
    		count++;
		}
    }
    return count;
}
int isinteger(char buffer[]){
	int i,flag=0,count=0;
	int ascii=int(buffer[0]);
	if(ascii>=48 && ascii<=57){
		for(i=0;i<strlen(buffer);i++)
		{
			if(buffer[i]=='.')
			flag++;
		}
		if(flag==0){
		cout<<buffer;
		cout<<" is an INTEGER \n";
		count++;
      	}
	}
	return count;
}

int isreal(char buffer[]) {
	int i,flag=0,count=0;
	int ascii=int(buffer[0]);
	if(ascii>=48 && ascii<=57){
		for(i=0;i<strlen(buffer);i++)
		{
			if(buffer[i]=='.')
			flag++;
		}
		if(flag==1){
		cout<<buffer;
		cout<<" is REAL \n";
		count++;
      	}
	}
	return count;
}
int main(){
    char ch, buffer[15], special[] = "()[]+-=,;";
    //string input;
    //cout<<"Enter the name of the source file \n";
    //getline(cin,input);
    //cout<<input;
   // int tot= (keycount+idcount+intcount+realcount+spcount);
    char symbolTable[100][20];
    ifstream fin("program.txt");
    int l=0,k=0,i,j=0,spcount=0,q,keycount=0,idcount=0,intcount=0,realcount=0;
    if(!fin.is_open()){
        cout<<"error while opening the file\n";
        exit(0);
    }
    
    while(!fin.eof()){
           ch = fin.get();
        for(i = 0; i < 9; ++i){
               if(ch == special[i]){
                   cout<<ch<<" is Special \n"; 
                   spcount++; 
                }
           }
           if(isalnum(ch) || ch=='.')
               buffer[j++] = ch;
		    else if((ch == ' ' || ch == '\n' || ch=='(' || ch==')' || ch== '[' || ch==']' || ch=='+' || ch=='-' || ch=='=' || ch==',' || ch==';') && (j != 0)){
                   buffer[j] = '\0';
                   k++;
                   j = 0;
            
           if(isKeyword(buffer) > 0) 
		     keycount++ ;
           if(isid(buffer)>0)
		     idcount++;
		   if(isinteger(buffer)>0)
		     intcount++;
		   if(isreal(buffer)>0)
		     realcount++;
            }
    }
    cout<<"\n   TOKEN SUMMERY REPORT\n";
    cout<<"\nNumber of KEYWORD Tokens: ";
    cout<<keycount;
    cout<<"\nNumber of IDENTIFIER Tokens: ";
    cout<<idcount;
    cout<<"\nNumber of INTEGER Tokens: ";
    cout<<intcount;
    cout<<"\nNumber of REAL Tokens: ";
    cout<<realcount;
    cout<<"\nNumber of SPECIAL Tokens: ";
    cout<<spcount;
     fin.close(); 
    return 0;
}
