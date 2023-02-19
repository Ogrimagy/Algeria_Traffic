//Mohammedi El hadi Groupe 4

package Project;

class Dijskra{
	
    private static final int N=12, Max=99999; // N represente le nombre de wilaya 
    private int tab[] = new int[N];
	private String city[]= {"---","Alger","Oran","Saida","Djelfa","Skikda","Biskra","Laghoat","Ouargla","Adrar","Illizi","Tamanrasset"};
    private String maChaine3 ="", maChaine2 ="";
    public boolean Mat[][] = new boolean[12][12];

    int MinDistance(int dist[], Boolean Turn[]){
        int min = Max, min_index=-1;

        for (int v = 0; v < N; v++)
            if (Turn[v] == false && dist[v] <= min){
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }
    
    public void dijkstra(int graph[][], int src, int dest){
        Boolean Turn[] = new Boolean[N];
        int dist[] =new int[N];

        for(int i=0;i<N;i++){
            dist[i] = Max;
            Turn[i] = false;
        }

        dist[src] = 0;
        for (int c = 0; c < N-1; c++){
            int u = MinDistance(dist, Turn);
            Turn[u] = true;
            for (int v = 0; v < N; v++){
            	if (dist[u] != Max && !Turn[v] && graph[u][v]!=0  && dist[u]+graph[u][v] < dist[v]){
            		dist[v] = dist[u] + graph[u][v];
            		tab[v]=u;
            		if(v==dest){
            			initialiser_matrice(N,N,Mat);
            			maChaine3="";
            			maChaine3="The shortest path is "+afficher_chemin(v,u,src);
            		}
                }
            }
        }
        maChaine2="The minimum distance to go from "+city[src]+" to "+city[dest]+" is :"+dist[dest]+" Km";
    }
    
    public String afficher_chemin(int u, int v, int src){
    	if(v==src){
    		Mat[v][u]=true;													//Display in Paint Function
    		return maChaine3+=" "+city[v]+" "+city[u];						//Display with Text
    	}
    	else{
    		Mat[v][u]=true;													//Display in Paint Function
    		return maChaine3+=afficher_chemin(v,tab[v],src)+" "+city[u];	//Display with Text
    	}
    }
    
    public void initialiser_matrice(int n, int m,boolean mat[][]){
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				mat[i][j]=false;
	}
    
    public boolean[][] getMat(){
		return Mat;
	}

    public String getMaChaine3(){
		return maChaine3;
	}
    
	public String getMaChaine2(){
		return maChaine2;
	}
}