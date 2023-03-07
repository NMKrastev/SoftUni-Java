package p06_TirePressureMonitoringSystem;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class AlarmTest {

    private Sensor sensor;
    private Alarm alarm;
    private static final double LOW_PRESSURE = 14.0;
    private static final double NORMAL_PRESSURE = 19.0;
    private static final double HIGH_PRESSURE = 14.0;

    @Before
    public void setUp() {
        sensor = mock(Sensor.class);
        alarm = new Alarm(sensor);
    }

    @Test
    public void testAlarmShouldBeOnDueToLowPressure () {
        when(sensor.popNextPressurePsiValue()).thenReturn(LOW_PRESSURE);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmShouldBeOnDueToHighPressure() {
        when(sensor.popNextPressurePsiValue()).thenReturn(HIGH_PRESSURE);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmShouldBeOff() {
        when(sensor.popNextPressurePsiValue()).thenReturn(NORMAL_PRESSURE);
        alarm.check();
        assertFalse(alarm.getAlarmOn());
    }

}