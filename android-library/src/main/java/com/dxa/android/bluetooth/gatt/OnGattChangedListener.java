package com.dxa.android.bluetooth.gatt;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;

/**
 * 当状态改变时的监听
 */

public interface OnGattChangedListener {

    /**
     * 连接设备成功
     */
    void onConnected(BluetoothGatt gatt);

    /**
     * Callback invoked when the list of remote services, characteristics and descriptors
     * for the remote device have been updated, ie new services have been discovered.
     *
     * @param gatt GATT client invoked {@link BluetoothGatt#discoverServices}
     */
    void onServiceDiscover(BluetoothGatt gatt);

    /**
     * Callback reporting the result
     *
     * @param gatt           GATT client invoked {@link BluetoothGatt#readCharacteristic}
     * @param characteristic Characteristic that was read from the associated remote device.
     * @param status         {@link BluetoothGatt#GATT_SUCCESS} if the read operation
     *                       was completed successfully.
     */
    void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status);

    /**
     * Callback indicating the result of a characteristic write operation.
     * <p>
     * <p>If this callback is invoked while a reliable write transaction is
     * in progress, the value of the characteristic represents the value
     * reported by the remote device. An application should compare this
     * value to the desired value to be written. If the values don't match,
     * the application must abort the reliable write transaction.
     *
     * @param gatt           GATT client invoked {@link BluetoothGatt#writeCharacteristic}
     * @param characteristic Characteristic that was written to the associated remote device.
     */
    void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic);

    /**
     * Callback triggered as a result of a remote characteristic notification.
     * 远程设备特征值改变提醒的回调
     *
     * @param gatt           GATT client the characteristic is associated with
     * @param characteristic Characteristic that has been updated as a result
     *                       of a remote notification event.
     */
    void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic);

    /**
     * Callback reporting the result of a descriptor read operation.
     *
     * @param gatt       GATT client invoked {@link BluetoothGatt#readDescriptor}
     * @param descriptor Descriptor that was read from the associated remote device.
     */
    void onDescriptorRead(BluetoothGatt gatt, BluetoothGattDescriptor descriptor);

    /**
     * Callback indicating the result of a descriptor write operation.
     *
     * @param gatt       GATT client invoked {@link BluetoothGatt#writeDescriptor}
     * @param descriptor Descriptor that was writte to the associated remote device.
     */
    void onDescriptorWrite(BluetoothGatt gatt, BluetoothGattDescriptor descriptor);

    /**
     * Callback invoked when a reliable write transaction has been completed.
     *
     * @param gatt GATT client invoked {@link BluetoothGatt#executeReliableWrite}
     */
    void onReliableWriteCompleted(BluetoothGatt gatt);

    /**
     * Callback reporting the RSSI for a remote device connection.
     * <p>
     * This callback is triggered in response to the
     * {@link BluetoothGatt#readRemoteRssi} function.
     *
     * @param gatt GATT client invoked {@link BluetoothGatt#readRemoteRssi}
     * @param rssi The RSSI value for the remote device
     */
    void onReadRemoteRssi(BluetoothGatt gatt, int rssi);

    /**
     * Callback indicating the MTU for a given device connection has changed.
     * <p>
     * This callback is triggered in response to the
     * {@link BluetoothGatt#requestMtu} function, or in response to a connection event.
     *
     * @param gatt GATT client invoked {@link BluetoothGatt#requestMtu}
     * @param mtu  The new MTU size
     */
    void onMtuChanged(BluetoothGatt gatt, int mtu);

    /**
     * 设备断开
     */
    void onDisconnected(BluetoothGatt gatt);

}