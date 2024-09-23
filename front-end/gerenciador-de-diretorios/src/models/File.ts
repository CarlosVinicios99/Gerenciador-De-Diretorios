export default interface File {
    fileId: string
    name: string
    superDirectoryId: string
    createdTimestamp?: number
    updatedTimestamp?: number
}