package com.sg.tdgarage.structure;

import com.sg.tdgarage.core.Constant;

public class Shuttle {
    //    //状态
//    private Integer state;
//    //梭车相对楼层的位置
//    private Position position;

    /**
     * 穿梭车当前状态
     */
    private Status status;

    /**
     * 穿梭车当前位置
     */
    private PSPosition position;

    /**
     * 所属车库数组
     */
    private Building[] owners;

    /**
     * 当前所在车库
     */
    private Building currentBuilding;

    //    //楼号
//    private Integer buildingNum;
    //层号
    private Integer floorNum;
    //当前行为要花费的时间
    private Double currentCostTime;
    /**
     * 上一次运行结束的时间
     */
    private TimeSpot end;

    public Shuttle(Building[] owners, int floor) {
        this.status = Status.STOP;
        this.position = new PSPosition(floor, Constant.LIFTER_SPOT_NO);
        this.owners = owners;
        this.currentBuilding = owners[0];
        owners[0].setFloorScanSequence(new int[] {4, 2, 3});
        owners[1].setFloorScanSequence(new int[] {3, 4, 2});
    }

//    public HorizontalShuttle(int buildingNum){
//        this.state = Constant.ON_FREE;
//        this.position = new Position(Constant.MID,0);
//        this.buildingNum = buildingNum;
//    }
//    public Integer getState() {
//        return state;
//    }
//
//    public HorizontalShuttle setState(Integer state) {
//        this.state = state;
//        return this;
//    }

//    public Position getPosition() {
//        return position;
//    }
//
//    public HorizontalShuttle setPosition(Position position) {
//        this.position = position;
//        return this;
//    }

//    public Integer getBuildingNum() {
//        return buildingNum;
//    }
//
//    public Shuttle setBuildingNum(Integer buildingNum) {
//        this.buildingNum = buildingNum;
//        return this;
//    }

    public void setCurrentBuilding(Building currentBuilding) {
        this.currentBuilding = currentBuilding;
    }

    public Integer getFloorNum() {
        return floorNum;
    }

    public Shuttle setFloorNum(Integer floorNum) {
        this.floorNum = floorNum;
        return this;
    }

    public Double getCurrentCostTime() {
        return currentCostTime;
    }

    public Shuttle setCurrentCostTime(Double currentCostTime) {
        this.currentCostTime = currentCostTime;
        return this;
    }

    public void leaveBuilding(Building building) {
        if (owners[0] == building) {
            setCurrentBuilding(owners[1]);
        } else {
            setCurrentBuilding(owners[0]);
        }
    }

    public TimeSpot getEnd() {
        return end;
    }

    public void setEnd(TimeSpot end) {
        this.end = end;
    }

    private enum Status {
        RUNNING, STOP
    }

}