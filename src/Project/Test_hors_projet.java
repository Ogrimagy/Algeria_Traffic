//Mohammedi El hadi Groupe 4
//cette classe est hors le projet

package Project;

class Test_hors_projet{
	
    private static final int N=9, Max=99999;
    private int tab[] = new int[N];
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
            		tab[v]=u;																	//tableau qui stoque les precedents des points
            		System.out.println("point ("+v+") son calcul est  "+dist[v]+" = "+dist[u]+" + "+ graph[u][v]);
            		System.out.println("point ("+v+") son precedent est le point ("+u+"), donc tab["+v+"] = "+u+"\n");
            		if(v==dest){
            			initialiser_matrice(N,N,Mat); 
            			maChaine3=""; 															// reinitialiser la chaine car la cas de point 8 entre 2 fois dans la boucle
            			maChaine3="The shortest path is "+afficher_chemin(v,u,src);
            			System.out.println("\n"+maChaine3);
            		}
                }
            }
        }
        maChaine2="The minimum distance to go from "+src+" to "+dest+" is :"+dist[dest]+" Km";
        System.out.println(maChaine2);
    }
    
    public String afficher_chemin(int u, int v, int src){ 										//un appel recursive du destination vers la source
    	if(v==src){
    		Mat[v][u]=true;																		//Display in Paint Function
    		return maChaine3+=" "+v+" "+u;														//Display with Text
    	}
    	else{
    		Mat[v][u]=true;																		//Display in Paint Function
    		return maChaine3+=afficher_chemin(v,tab[v],src)+" "+u;								//Display with Text
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

	public static void main (String[] args){
    int Mat[][] = new int[][]{// 0 ,  1,  2,  3,  4,  5
    							{0 ,  4,  2,  0,  0,  0},// 0
                                {0 ,  0,  5,  10, 0,  0},// 1
                                {0 ,  0,  0,  0,  3,  0},// 2
                                {0 ,  0,  0,  0,  0, 11},// 3
                                {0 ,  0,  0,  4,  0,  0},// 4
                                {0 ,  0,  0,  0,  0,  0},// 5
                             };
        Test_hors_projet t = new Test_hors_projet();
        t.dijkstra(Mat, 0, 4);
    }
}