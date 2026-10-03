/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ur_os.memory.freememorymagament;

public class BestFitMemorySlotManager extends FreeMemorySlotManager{
    
    public BestFitMemorySlotManager(int memSize){
        super(memSize);
    }
    
    @Override
    public MemorySlot getSlot(int size) {
        MemorySlot best = null;

        for (MemorySlot memorySlot : list) {
            if (memorySlot.canContain(size)) {
                if (best == null || memorySlot.getSize() < best.getSize()) {
                    best = memorySlot;
                }
            }
        }

        if (best != null) {
            if (best.getSize() == size) {
                list.remove(best);
                return best;
            } else {
                return best.assignMemory(size);
            }
        }

        System.out.println("Error - No suitable slot found (Best Fit)");
        return null;
    }
}
