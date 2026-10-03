/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ur_os.system;

import java.util.Scanner;
import ur_os.memory.MemoryManagerType;
import ur_os.memory.freememorymagament.FreeMemorySlotManagerType;

public class MainMenu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== MEMORY MANAGEMENT MENU =====");

        // 🔹 Elegir escenario
        System.out.println("Choose scenario:");
        System.out.println("1. MEMORY_TEST_1");
        System.out.println("2. MEMORY_TEST_2");

        int scenarioOption = sc.nextInt();

        SimulationType simType;

        if (scenarioOption == 2) {
            simType = SimulationType.MEMORY_TEST_2;
        } else {
            simType = SimulationType.MEMORY_TEST_1;
        }

        // 🔥 NUEVO: tipo de memoria
        System.out.println("\nChoose memory type:");
        System.out.println("1. CONTIGUOUS");
        System.out.println("2. PAGING");
        System.out.println("3. SEGMENTATION");

        int memoryTypeOption = sc.nextInt();

        MemoryManagerType memoryType;

        switch (memoryTypeOption) {
            case 2:
                memoryType = MemoryManagerType.PAGING;
                break;
            case 3:
                memoryType = MemoryManagerType.SEGMENTATION;
                break;
            default:
                memoryType = MemoryManagerType.CONTIGUOUS;
                break;
        }

        OS.SMM = memoryType;

        if (memoryType == MemoryManagerType.CONTIGUOUS) {

            System.out.println("\nChoose memory algorithm:");
            System.out.println("1. BEST FIT");
            System.out.println("2. WORST FIT");
            System.out.println("3. FIRST FIT");
            System.out.println("4. NEXT FIT");

            int algoOption = sc.nextInt();

            FreeMemorySlotManagerType msm;

            switch (algoOption) {
                case 2:
                    msm = FreeMemorySlotManagerType.WORST_FIT;
                    break;
                case 3:
                    msm = FreeMemorySlotManagerType.FIRST_FIT;
                    break;
                case 4:
                    msm = FreeMemorySlotManagerType.NEXT_FIT;
                    break;
                default:
                    msm = FreeMemorySlotManagerType.BEST_FIT;
                    break;
            }

            OS.MSM = msm;
        }

        SystemOS system = new SystemOS(simType);
        system.run();
    }
}