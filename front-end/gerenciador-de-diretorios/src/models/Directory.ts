export default interface Directory {
    directoryId: string
    name: string
    superDirectoryId?: string
    createdTimestamp?: number
    updatedTimestamp?: number
}