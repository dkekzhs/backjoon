import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Main {
    static int N,K;
    static boolean visited[];
    static ArrayList<Player> playerList;
    static Player[] playerInput;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s[] = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);

        playerInput = new Player[N];
        playerList = new ArrayList<Player>();
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            playerInput[i] = new Player(Integer.parseInt(s[0]), s[1]);
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                int createRoomNumber = playerInput[i].number;
                int count = 0;
                for (int j = i; j < N; j++) {
                    if (!visited[j] && calculator(createRoomNumber,j) ) {
                        visited[j] = true;
                        count++;
                        playerList.add(playerInput[j]);
                        if(count == K) break;
                    }
                }
                if(playerList.size() != K) sb.append("Waiting!").append("\n");
                else sb.append("Started!").append("\n");
                Collections.sort(playerList, ((o1, o2) -> o1.player.compareTo(o2.player)));
                for(Player p : playerList){
                    sb.append(p.number).append(" ").append(p.player).append("\n");
                }
                playerList.clear();

            }
        }

        System.out.println(sb);


    }

    private static boolean calculator(int createRoomNumber, int j) {
        int playerNumber = playerInput[j].number;
        if(Math.abs(createRoomNumber  - playerNumber) <= 10){
            return true;
        }
        return false;

    }

    static class Player {
        int number;
        String player;

        public Player(int number, String player) {
            this.number = number;
            this.player = player;
        }


    }

    }


