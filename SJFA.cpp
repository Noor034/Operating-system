#include<iostream>
using namespace std;

int main()
{
    int totalp, temp, x=0,  min, d, i,j;
    float avg_tat=0, avg_wt=0, t_tat=0, t_wt=0;
    cout<<"Enter total number of processes: \n";
    cin>>totalp;

    int p[totalp], atime[totalp], bt[totalp], ct[totalp], tat[totalp], wt[totalp];
    cout<< "Enter process sequence: \n" ;
    for(i=0; i<totalp; i++)
    {
        cin>>p[i];
    }

    cout<< "Enter arrival time: \n" ;
    for(i=0; i<totalp; i++)
    {
        cin>>atime[i];
    }

    cout<< "Enter burst time: \n" ;
    for(i=0; i<totalp; i++)
    {
        cin>>bt[i];
    }

    for(i=0; i<totalp; i++)
    {
        for(j=i+1; j<totalp; j++)
        {
            if(bt[i] >bt[j])
            {
                temp = p[i];
                p[i] = p[j];
                p[j] = temp;

                temp = atime[i];
                atime[i] = atime[j];
                atime[j] = temp;

                temp = bt[i];
                bt[i] = bt[j];
                bt[j] = temp;


            }
        }
    }
    min =atime[0];
    for(i=0; i<totalp; i++){
        if (min > atime[i])
        {
            min =atime[i];
            d =i;

        }
    }
    x= min;
    ct[d] = x+ bt[d];
    x=ct[d];

    for(i=0; i<totalp; i++){
        if (atime[i] != min)
        {
            ct[i]=bt[i]+x;
            x= ct[i];


        }



}
