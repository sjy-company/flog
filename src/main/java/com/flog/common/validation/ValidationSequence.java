package com.flog.common.validation;

import jakarta.validation.GroupSequence;

@GroupSequence({
	ValidationGroups.First.class,
	ValidationGroups.Second.class,
	ValidationGroups.Third.class,
	ValidationGroups.Fourth.class,
	ValidationGroups.Fifth.class,
	ValidationGroups.Sixth.class,
	ValidationGroups.Seventh.class,
	ValidationGroups.Eighth.class,
	ValidationGroups.Ninth.class,
	ValidationGroups.Tenth.class,
	ValidationGroups.Eleventh.class,
	ValidationGroups.Twelfth.class,
	ValidationGroups.Thirteenth.class,
	ValidationGroups.Fourteenth.class,
	ValidationGroups.Fifteenth.class,
	ValidationGroups.Sixteenth.class,
	ValidationGroups.Seventeenth.class,
	ValidationGroups.Eighteenth.class,
	ValidationGroups.Nineteenth.class,
	ValidationGroups.Twentieth.class
})
public interface ValidationSequence {
}
