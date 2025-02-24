type TextInputProps = {
    label: string,
    id: string
}


function TextInput({ label, id }: TextInputProps) {

    return (
        <>
            <div>
                <label htmlFor={id} className="block font-medium text-gray-900">
                    {label}
                </label>
                <div className="flex items-center bg-white pl-3 border border-black focus-within:border-orange-700"><div />
                    <input id={id} name={label} type="text" className="block min-w-0 grow py-1.5 pr-3 pl-1 text-base text-gray-900 placeholder:text-gray-400 focus:outline-none sm:text-sm/6"/>
                </div>
            </div>
        </>
    )
}

export default TextInput;