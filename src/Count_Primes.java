/**
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class Count_Primes {
    public int countPrimes(int n) {
        if(n<2)return 0;
        boolean[] primes = new boolean[n];
        double up = Math.sqrt(n);
        primes[0] =  primes[1] = false;
        for(int i=2;i<n;i++){
            primes[i] = true;
        }

        for(int i=2;i<up;i++){
            if(primes[i]){
                for (int j=2;j*i<n; j++){
                    primes[i*j] = false;
                }
            }
        }
        int count = 0;
        for(int i=0;i<n;i++){
            if(primes[i]){
                count++;
            }
        }
        return count;
    }
}
