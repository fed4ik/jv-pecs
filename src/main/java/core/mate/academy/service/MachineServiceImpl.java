package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import java.util.ArrayList;
import java.util.List;

/**
 * Your implementation of MachineService.
 */
public class MachineServiceImpl implements MachineService<Machine> {
    private BulldozerProducer bulldozerProducer = new BulldozerProducer();
    private ExcavatorProducer excavatorProducer = new ExcavatorProducer();
    private TruckProducer trackProducer = new TruckProducer();

    @Override
    public List<Machine> getAll(Class type) {
        List<? extends Machine> machines = new ArrayList<>();
        if (Excavator.class.equals(type)) {
            machines = excavatorProducer.get();
        }
        if (Bulldozer.class.equals(type)) {
            machines = bulldozerProducer.get();
        }
        if (Truck.class.equals(type)) {
            machines = trackProducer.get();
        }
        return new ArrayList<>(machines);
    }

    @Override
    public void fill(List<? super Machine> machines, Machine value) {
        for (int i = 0; i < machines.size(); i++) {
            machines.set(i, value);
        }
    }

    @Override
    public void startWorking(List<? extends Machine> machines) {
        for (Machine machine : machines) {
            machine.doWork();
        }
    }
}
