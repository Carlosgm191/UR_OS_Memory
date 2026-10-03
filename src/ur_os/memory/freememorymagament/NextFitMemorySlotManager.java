/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ur_os.memory.freememorymagament;

public class NextFitMemorySlotManager extends FreeMemorySlotManager {

    private int lastIndex = 0;

    public NextFitMemorySlotManager(int memSize){
        super(memSize);
    }

    @Override
    public MemorySlot getSlot(int size) {

        // Primera pasada: desde última posición
        for (int i = lastIndex; i < list.size(); i++) {
            MemorySlot memorySlot = list.get(i);

            if (memorySlot.canContain(size)) {
                if (memorySlot.getSize() == size) {
                    list.remove(memorySlot);
                    lastIndex = i;
                    return memorySlot;
                } else {
                    lastIndex = i;
                    return memorySlot.assignMemory(size);
                }
            }
        }

        // Segunda pasada: desde el inicio
        for (int i = 0; i < lastIndex; i++) {
            MemorySlot memorySlot = list.get(i);

            if (memorySlot.canContain(size)) {
                if (memorySlot.getSize() == size) {
                    list.remove(memorySlot);
                    lastIndex = i;
                    return memorySlot;
                } else {
                    lastIndex = i;
                    return memorySlot.assignMemory(size);
                }
            }
        }

        System.out.println("Error - No suitable slot found (Next Fit)");
        return null;
    }
}
