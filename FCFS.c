#include<stdio.h>
struct process{
    int pid, arrival,burst,turnaround;
};

int main(){
    int i,j,totalp;
    float avg=0.0,sum=0.0;
    struct process p[10], temp;
    printf("Enter the number of processes: \n");
    scanf("%d",&totalp);

    for(i=0; i<totalp; i++){
        printf("Enter Arrival Time and Burst Time for the process %d: \n",i+1);
        scanf("%d %d",&p[i].arrival,&p[i].burst);
        p[i].pid=i+1;
    }

    for(i=0; i<totalp-1; i++){
        for(j=0; j<totalp-i-1; j++){
            if(p[j].arrival > p[j+1].arrival)
            {
                temp=p[j];
                p[j]=p[j+1];
                p[j+1]=temp;
            }
        }
    }
    for(i=0; i<totalp; i++){
        sum = sum + p[i].burst;
        p[i].turnaround =sum;

    }
    sum=0;
    for(i=0; i <50 ;i++){
        printf("-");
    }
    printf("\n");
    printf("PID  ArrivalTime  BurstTime TurnaroundTime \n");
    for(i=0; i <50 ;i++){
        printf("-");
    }
    printf("\n");
    for(i=0; i<totalp; i++){
        printf("%d \t %d \t %d \t %d\n",p[i].pid,p[i].arrival,p[i].burst,p[i].turnaround);
        sum+= p[i].turnaround;

    }

    for(i=0; i <50 ;i++){
        printf("-");
    }
    printf("\n");

    avg = sum/(float)totalp;
    printf("\n Total turnaround time : %.3f \n",sum);
    printf("Average turnaround time : %.3f",avg);
    return 0;



}
