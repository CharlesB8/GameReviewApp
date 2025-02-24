import TextInput from "../components/Forms/TextInput";
import Button from "../components/Forms/Button";

function CreateGame() {

    return (
        <form>
            <div className="flex flex-col items-center justify-center gap-y-6 top-5">
                <h1 className="text-2xl font-semibold text-black">Add a New Game! </h1>

                <TextInput label="Name" id="name" />
                <TextInput label="Description" id="description" />
                <TextInput label="Logo URL" id="logo_url" />
                <Button title="Add Game"/>
            </div>
        </form>
    )
}

export default CreateGame;