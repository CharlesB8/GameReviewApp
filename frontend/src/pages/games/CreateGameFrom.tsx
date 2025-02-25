import LabeledInput from "../components/Forms/LabeledInput";
import Button from "../components/Forms/Button";
import {useFormik} from "formik";
import * as Yup from 'yup';

const validationSchema = Yup.object({
    title: Yup.string()
        .max(12, "Max of 12")
        .required('Title is required'),
    description: Yup.string()
        .required('Description is required'),
    logoUrl: Yup.string()
        .url("Must be valid url")
        .required('Logo is required'),
});

function CreateGameForm() {

    const formik = useFormik({
        initialValues: {
            title: '',
            description: '',
            logoUrl: '',
        },
        validationSchema,
        onSubmit: values => {
            alert(JSON.stringify(values, null, 2));
        },
    });

    return (
        <form onSubmit={formik.handleSubmit}>
            <div className="flex flex-col items-center justify-center gap-y-6 top-5">
                <h1 className="text-2xl font-semibold text-black">Add a New Game! </h1>

                <LabeledInput
                    label="Title"
                    id="name"
                    {...formik.getFieldProps("title")}
                />
                {formik.touched.title && formik.errors.title ? <div className="text-red-600 text-sm">{formik.errors.title}</div> : null}

                <LabeledInput
                    label="Description"
                    id="description"
                    {...formik.getFieldProps("description")}
                />
                {formik.touched.description && formik.errors.description ? <div className="text-red-600 text-sm">{formik.errors.description}</div> : null}

                <LabeledInput
                    label="Logo URL"
                    id="logo_url"
                    {...formik.getFieldProps("logoUrl")}
                />
                {formik.touched.logoUrl && formik.errors.logoUrl ? <div className="text-red-600 text-sm">{formik.errors.logoUrl}</div> : null}

                <Button title="Add Game"/>
            </div>
        </form>
    )
}

export default CreateGameForm;