package learn.progrom.basic.jvm;

/**
 * 内存分配与回收
 */
public class MemoryAllocation {

    public static void main(String[] args) {
        MemoryAllocation allocation = new MemoryAllocation();
        allocation.testAllocation();
    }

    private void testAllocation() {
        int M = 1024 * 1024;

        byte[] allocatino1 = new byte[2 * M];
        byte[] allocatino2 = new byte[2 * M];
        byte[] allocatino3 = new byte[2 * M];

        byte[] allocatino4 = new byte[4 * M];
    }
}
