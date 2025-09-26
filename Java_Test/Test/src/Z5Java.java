import java.util.Deque;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;;

public class Z5Java {
    public static void main(String[] args) {
        int n, w, l;
        Scanner scanner = new Scanner(System.in);

        String[] inputFirst = scanner.nextLine().split(" "); // ["4", "2", "10"]

        n = Integer.parseInt(inputFirst[0]);
        w = Integer.parseInt(inputFirst[1]);
        l = Integer.parseInt(inputFirst[2]);
        
        String[] inputSecond = scanner.nextLine().split(" "); // ["7", "4", "5", "6"]

        scanner.close();

        int[] weights = new int[inputSecond.length];

        for (int i = 0; i < inputSecond.length; i++) {
            weights[i] = Integer.parseInt(inputSecond[i]);
        }

        int elapsed = 0;
        int currentWeight = 0;

        Deque<Integer> bridge = new LinkedBlockingDeque<>(w);

        int i = 0;

        while (i < n) {
            elapsed += 1;

            for (int j = 0; j < bridge.size(); j++) {
                bridge.
            }

            currentWeight -= bridge.getFirst();

            if ((currentWeight + weights[i] <= l) && bridge.offerLast(weights[i])) {
                currentWeight += weights[i];
                i += 1;
            }
            else {
                bridge.addLast(0);
            }
        }

        elapsed += w;
        System.out.println(elapsed);
    }
}

// import collections

// n, w, l = map(int, input().split()) # n트럭의 수, w다리 길이, l최대 하중
// # print(f"{n}, {w}, {l}")

// weights = list(map(int, input().split()))
// '''
// weights = []
// for i in range(1000) :
//     weights.append(10)
// '''

// elapsed = 0 # 시간 경과
// current_weight = 0 # 현재 하중

// bridge = collections.deque([0] * w)
// # bridge = collections.deque([1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
// # print(bridge)

// # bridge.popleft()
// # print(bridge)

// # 4 2 10
// # 7 4 5 6

// i = 0

// while i < n :
//     elapsed += 1

//     out = bridge.popleft() # <- [] <-, 리턴은 다리에서 나간 무게
//     current_weight -= out

//     if (weights[i] + current_weight <= l) :
//         bridge.append(weights[i])
//         current_weight += weights[i]
//         i += 1
//     else :
//         bridge.append(0)

//     # print(list(bridge))

// elapsed += w # 마지막 트럭이 지나갈 때 까지 걸리는 시간은 다리 길이임 ([6, 0] -> [0 , 0])
// print(elapsed)