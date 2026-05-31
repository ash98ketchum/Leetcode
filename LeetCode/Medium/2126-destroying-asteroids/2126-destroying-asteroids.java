class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long curMass = mass;
        Arrays.sort(asteroids);
        for (int a : asteroids) {
            if (curMass < a) {
                return false;
            }
            curMass += a;
        }
        return true;
    }
}