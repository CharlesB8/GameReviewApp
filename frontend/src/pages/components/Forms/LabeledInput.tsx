import React from "react";
import {FieldHookConfig, FormikProps, useField} from "formik";

interface LabeledInputProps {
    label: string
    props: FieldHookConfig<string>
}


function LabeledInput({label, props}: LabeledInputProps) {
    const [field, meta] = useField(props);

   return (
       <>
            <label htmlFor={props.id} className="block font-medium text-gray-900">
                {label}
            </label>
            <div className="flex items-center bg-white pl-3 border border-black focus-within:border-orange-700">
                <div/>
                <input
                    type="text"
                    className="block min-w-0 grow py-1.5 pr-3 pl-1 text-base text-gray-900 placeholder:text-gray-400 focus:outline-none sm:text-sm/6"
                    {...props}
                    {...field}
                />
                {meta.touched && meta.error ? (
                    <div className="error">{meta.error}</div>
                ) : null}
            </div>
        </>
   )
}

export default LabeledInput;