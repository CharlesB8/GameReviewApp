import LabeledInput from "../components/Forms/LabeledInput";
import Button from "../components/Forms/Button";
import {useFormik} from "formik";
import * as Yup from 'yup';
import api from "../../api";
import {useNavigate} from "react-router-dom";

const validationSchema = Yup.object({
    title: Yup.string()
        .min(1)
        .max(12, "Max of 12")
        .required('Title is required'),
    description: Yup.string()
        .min(1)
        .required('Description is required'),
    logoUrl: Yup.string()
        .url("Must be valid url")
        .required('Logo is required'),
});

function CreateGameForm() {

    const navigate = useNavigate();

    const formik = useFormik({
        initialValues: {
            title: '',
            description: '',
            logoUrl: '',
        },
        validationSchema,
        onSubmit: async (values) => {
            api.post('/games/new', values)
                .then(response => {
                    alert("Game Created!")
                    console.log("Success", response.data);
                })
                .catch(error => {
                    alert("Something went wrong!")
                    console.error("Something went wrong creating game", error);
                });
            formik.resetForm();
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