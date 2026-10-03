package ur_os.memory.freememorymagament;

import java.util.LinkedList;

public class MiddleFitMemorySlotManager extends FreeMemorySlotManager {

    public MiddleFitMemorySlotManager(int memSize) {
        super(memSize);
    }

    @Override
    public MemorySlot getSlot(int size) {
        MemorySlot m = null;

        LinkedList<MemorySlot> candidates = new LinkedList<>();
        for (MemorySlot slot : list) {
            if (slot.canContain(size)) {
                candidates.add(slot);
            }
        }

        if (!candidates.isEmpty()) {
            int middleIndex = candidates.size() / 2;
            m = candidates.get(middleIndex);
            return m.assignMemory(size);
        }

        return null;
    }

}
