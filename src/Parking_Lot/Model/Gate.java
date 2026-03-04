package Parking_Lot.Gate;

import Parking_Lot.Model.Enum.GateType;

abstract class Gate {
     protected final String id;

     public abstract GateType getType();
}
