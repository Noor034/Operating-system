#include<stdio.h>
struct process{
    int pid, wait,burst,turnaround;
};
int main(){
    int i,j,totalp;
    float w_avg=0.0,t_avg=0.0,sum=0.0,w_total=0.0,t_total=0.0;
    struct process p[10], temp;
    printf("Enter the number of processes: \n");
    scanf("%d",&totalp);

    for(i=0; i<totalp; i++){
        printf("Enter Burst Time for the process %d: \n",i+1);
        scanf("%d",&p[i].burst);
        p[i].pid=i+1;
    }

    for(i=0; i<totalp-1; i++){
        for(j=0; j<totalp-i-1; j++){
            if(p[j].burst > p[j+1].burst)
            {
                temp=p[j];
                p[j]=p[j+1];
                p[j+1]=temp;
            }
        }
    }
     for(i=0; i<totalp; i++){
        p[i].wait =sum;
        sum = sum + p[i].burst;
        p[i].turnaround =sum;

    }

    for(i=0; i <50 ;i++){
        printf("-");
    }
    printf("\n");
    printf("PID  BurstTime WaitingTime TurnaroundTime \n");
    for(i=0; i <50 ;i++){
        printf("-");
    }
    printf("\n");
    for(i=0; i<totalp; i++){
        printf("%d \t %d \t %d \t \t %d\n",p[i].pid,p[i].burst,p[i].wait,p[i].turnaround);
        w_total+= p[i].wait;
        t_total+= p[i].turnaround;

    }
    w_avg = w_total/(float)totalp;
    t_avg = t_total/(float)totalp;

    printf("\n Total turnaround time : %.3f \n",t_total);
    printf("Average turnaround time : %.3f",t_avg);

    printf("\n Total waiting time : %.3f \n",w_total);
    printf("Average waiting time : %.3f",w_avg);

    return 0;



}

